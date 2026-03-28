package xmlParser;

// ============================================================
// [ DOM 파싱에 필요한 import ]
// ============================================================
// DocumentBuilderFactory : DOM 파서 객체를 생성하는 팩토리 클래스
// DocumentBuilder        : 실제로 XML 파일을 읽어서 Document 트리로 만들어주는 파서
// Document               : XML 전체 구조를 메모리에 트리 형태로 표현한 객체 (DOM 트리의 루트)
// Element                : XML의 개별 태그(<student>, <name> 등)를 표현하는 클래스
// NodeList               : 같은 이름을 가진 여러 태그의 목록 (예: 모든 <student> 태그들)
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// ============================================================
// [ SAX 파싱에 필요한 import ]
// ============================================================
// SAXParserFactory : SAX 파서 객체를 생성하는 팩토리 클래스
// SAXParser        : 실제로 XML 파일을 이벤트 방식으로 읽어 내려가는 파서
// DefaultHandler   : SAX 이벤트를 받아 처리하는 핸들러의 기본 클래스
//                    우리가 만들 핸들러 클래스는 이것을 상속해서 필요한 메서드만 재정의합니다
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// 파일 경로를 다루기 위한 표준 Java 클래스
import java.io.File;

// ============================================================
// XML 파싱 예제 메인 클래스
// ============================================================
// [ DOM vs SAX 파싱 방식 비교 ]
//
// DOM(Document Object Model) 파싱:
//   - XML 파일 전체를 메모리에 트리 구조로 올린 뒤 탐색합니다.
//   - 장점: 임의 접근(random access) 가능, 원하는 노드를 언제든 다시 방문 가능
//   - 단점: XML이 클수록 메모리를 많이 차지함
//   - 적합한 경우: 파일 크기가 작거나, 특정 데이터를 반복 검색해야 할 때
//
// SAX(Simple API for XML) 파싱:
//   - XML 파일을 위에서 아래로 한 줄씩 읽으며 이벤트를 발생시킵니다.
//   - 장점: 메모리를 거의 쓰지 않아 대용량 파일에 적합
//   - 단점: 이미 지나간 데이터로 되돌아갈 수 없음, 코드가 약간 복잡함
//   - 적합한 경우: 파일 크기가 매우 크거나, 처음부터 끝까지 순서대로 읽을 때
// ============================================================
public class XmlParserEx {

    // XML 파일의 상대 경로
    // 프로젝트 루트에서 실행한다고 가정합니다.
    // (IntelliJ 기준 Working Directory = 프로젝트 루트)
    private static final String currentPath = System.getProperty("user.dir");
    private static final String XML_FILE_PATH = currentPath + "/src/xmlParser/students.xml";

    public static void main(String[] args) {

        // ====================================================
        // DOM 파싱 예제 실행
        // ====================================================
        System.out.println("=".repeat(55));
        System.out.println("       DOM(Document Object Model) 파싱 예제");
        System.out.println("=".repeat(55));
        parseWithDOM();

        System.out.println(); // 두 예제 사이 빈 줄

        // ====================================================
        // SAX 파싱 예제 실행
        // ====================================================
        System.out.println("=".repeat(55));
        System.out.println("       SAX(Simple API for XML) 파싱 예제");
        System.out.println("=".repeat(55));
        parseWithSAX();
    }

    // =========================================================
    // DOM 파싱 메서드
    // =========================================================
    // DOM 파싱은 크게 세 단계로 이루어집니다.
    //   1단계: 파서(Parser) 준비  - DocumentBuilderFactory → DocumentBuilder
    //   2단계: XML 읽기           - DocumentBuilder.parse(file) → Document
    //   3단계: 트리 탐색          - getElementsByTagName 등으로 원하는 노드 꺼내기
    // =========================================================
    private static void parseWithDOM() {

        try {
            // --------------------------------------------------
            // 1단계: 파서 팩토리와 파서 준비
            // --------------------------------------------------

            // DocumentBuilderFactory.newInstance()
            //   DOM 파서를 만들기 위한 '공장'을 생성합니다.
            //   팩토리 패턴(Factory Pattern)을 사용하는 이유:
            //   나중에 네임스페이스 인식 여부, 검증(validation) 여부 등
            //   파서 옵션을 팩토리에 한 번만 설정하면 파서 객체마다 반복 설정할 필요가 없기 때문입니다.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // factory.newDocumentBuilder()
            //   팩토리에서 실제 파서 객체(DocumentBuilder)를 생성합니다.
            //   ParserConfigurationException 발생 가능 → try-catch 필요
            DocumentBuilder builder = factory.newDocumentBuilder();

            // --------------------------------------------------
            // 2단계: XML 파일을 파싱하여 Document(DOM 트리) 생성
            // --------------------------------------------------

            // builder.parse(file)
            //   XML 파일 전체를 읽어 메모리에 트리 구조의 Document 객체로 만듭니다.
            //   이 트리는 XML의 모든 태그, 속성, 텍스트를 노드(Node)로 표현합니다.
            //   - Document 노드: 트리의 최상위 루트
            //   - Element 노드 : 태그 (<students>, <student>, <name> 등)
            //   - Text 노드    : 태그 사이의 텍스트 ("김민준", "21" 등)
            //   - Attr 노드    : 태그의 속성 (id="1" 등)
            Document document = builder.parse(new File(XML_FILE_PATH));

            // normalize()
            //   파싱 후 텍스트 노드가 여러 조각으로 나뉘어 있을 수 있는데,
            //   이를 하나의 텍스트 노드로 합쳐주는 정규화 작업입니다.
            //   안 해도 대부분 동작하지만, 안전한 파싱을 위해 관행적으로 호출합니다.
            document.getDocumentElement().normalize();

            // --------------------------------------------------
            // 3단계: DOM 트리에서 원하는 데이터 꺼내기
            // --------------------------------------------------

            // getElementsByTagName("student")
            //   문서 전체에서 태그 이름이 "student"인 모든 Element를 찾아
            //   NodeList(노드 목록)로 반환합니다.
            //   NodeList는 배열처럼 인덱스로 접근할 수 있습니다.
            NodeList studentList = document.getElementsByTagName("student");

            System.out.println("총 학생 수: " + studentList.getLength() + "명\n");

            // studentList.getLength() : NodeList의 원소 개수를 반환합니다.
            for (int i = 0; i < studentList.getLength(); i++) {

                // item(i) : NodeList에서 i번째 노드를 꺼냅니다.
                // Element로 형변환(casting)하여 태그 관련 메서드를 사용할 수 있게 합니다.
                Element student = (Element) studentList.item(i);

                // getAttribute("id")
                //   현재 Element(<student>)의 "id" 속성값을 문자열로 반환합니다.
                //   XML에서 <student id="1"> 형태로 작성된 속성입니다.
                String id = student.getAttribute("id");

                // getElementsByTagName("name").item(0).getTextContent()
                //   현재 <student> 태그 안에서 <name> 태그를 찾고(item(0)),
                //   그 태그 안의 텍스트 내용("김민준" 등)을 가져옵니다.
                //   item(0)을 쓰는 이유: 자식 태그가 1개뿐이더라도
                //   getElementsByTagName은 항상 NodeList를 반환하기 때문입니다.
                String name  = student.getElementsByTagName("name").item(0).getTextContent();
                String age   = student.getElementsByTagName("age").item(0).getTextContent();
                String major = student.getElementsByTagName("major").item(0).getTextContent();
                String grade = student.getElementsByTagName("grade").item(0).getTextContent();
                String email = student.getElementsByTagName("email").item(0).getTextContent();

                // 파싱한 데이터 출력
                System.out.println("[ 학생 #" + id + " ]");
                System.out.println("  이름   : " + name);
                System.out.println("  나이   : " + age + "세");
                System.out.println("  전공   : " + major);
                System.out.println("  학년   : " + grade + "학년");
                System.out.println("  이메일 : " + email);
                System.out.println();
            }

        } catch (Exception e) {
            // DOM 파싱 중 발생할 수 있는 예외들:
            // - ParserConfigurationException : 파서 설정 오류
            // - SAXException                 : XML 문서 형식 오류 (DOM도 내부적으로 SAX를 사용)
            // - IOException                  : 파일을 읽지 못하는 경우 (파일 없음 등)
            System.err.println("[DOM 오류] " + e.getMessage());
            e.printStackTrace();
        }
    }

    // =========================================================
    // SAX 파싱 메서드
    // =========================================================
    // SAX 파싱도 크게 세 단계로 이루어집니다.
    //   1단계: 파서 준비       - SAXParserFactory → SAXParser
    //   2단계: 핸들러 준비     - DefaultHandler를 상속한 커스텀 핸들러 객체 생성
    //   3단계: 파싱 시작       - saxParser.parse(file, handler)
    //
    // SAX는 XML을 읽으면서 특정 시점에 이벤트를 발생시킵니다.
    //   - 태그 시작(<student>)  → startElement() 호출
    //   - 태그 종료(</student>) → endElement() 호출
    //   - 태그 사이 텍스트      → characters() 호출
    // 우리는 이 메서드들을 재정의(override)해서 원하는 로직을 넣습니다.
    // =========================================================
    private static void parseWithSAX() {

        try {
            // --------------------------------------------------
            // 1단계: 파서 팩토리와 파서 준비
            // --------------------------------------------------

            // SAXParserFactory.newInstance()
            //   SAX 파서를 만들기 위한 팩토리를 생성합니다.
            //   DOM과 마찬가지로 팩토리 패턴을 사용합니다.
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // factory.newSAXParser()
            //   팩토리에서 실제 SAX 파서 객체를 생성합니다.
            SAXParser saxParser = factory.newSAXParser();

            // --------------------------------------------------
            // 2단계: 이벤트를 처리할 핸들러 객체 생성
            // --------------------------------------------------
            // StudentSAXHandler는 이 파일 아래에 별도 클래스로 정의합니다.
            // DefaultHandler를 상속하여 필요한 이벤트 메서드만 재정의했습니다.
            StudentSAXHandler handler = new StudentSAXHandler();

            // --------------------------------------------------
            // 3단계: 파싱 시작
            // --------------------------------------------------
            // saxParser.parse(file, handler)
            //   XML 파일을 위에서 아래로 읽으면서,
            //   태그를 만날 때마다 handler의 메서드를 호출합니다.
            //   DOM과 달리 전체를 메모리에 올리지 않으므로 메모리 효율이 좋습니다.
            saxParser.parse(new File(XML_FILE_PATH), handler);

        } catch (Exception e) {
            // SAX 파싱 중 발생할 수 있는 예외들:
            // - ParserConfigurationException : 파서 설정 오류
            // - SAXException                 : XML 형식 오류 또는 핸들러 내부 예외
            // - IOException                  : 파일 읽기 오류
            System.err.println("[SAX 오류] " + e.getMessage());
            e.printStackTrace();
        }
    }
}

// =============================================================
// SAX 이벤트 핸들러 클래스
// =============================================================
// DefaultHandler를 상속합니다.
// DefaultHandler는 SAX의 모든 이벤트 메서드(startElement, endElement,
// characters 등)를 빈 메서드로 미리 구현해 놓은 편의 클래스입니다.
// 우리는 필요한 메서드만 골라서 @Override(재정의)하면 됩니다.
//
// SAX가 XML을 읽는 순서 (students.xml 기준):
//   startElement("students")
//     startElement("student")   ← id 속성도 함께 전달됨
//       startElement("name")
//         characters("김민준")
//       endElement("name")
//       startElement("age")
//         characters("21")
//       endElement("age")
//       ... (이하 반복)
//     endElement("student")
//   endElement("students")
// =============================================================
class StudentSAXHandler extends DefaultHandler {

    // ---- 상태를 기억하기 위한 인스턴스 변수 ----

    // currentElement : 현재 처리 중인 태그 이름을 저장합니다.
    //   SAX는 순차적으로 이벤트가 발생하므로, characters() 메서드가 호출될 때
    //   "지금 어느 태그 안에 있는가?"를 알려면 이 변수가 필요합니다.
    private String currentElement = "";

    // currentStudent : 현재 파싱 중인 학생의 데이터를 임시로 보관합니다.
    //   <student> 시작 시 초기화하고, </student> 종료 시 출력한 뒤 비웁니다.
    private String currentId    = "";
    private String currentName  = "";
    private String currentAge   = "";
    private String currentMajor = "";
    private String currentGrade = "";
    private String currentEmail = "";

    // 학생 번호 카운터 (출력 순서 표시용)
    private int studentCount = 0;

    // =========================================================
    // startElement() - 여는 태그(<태그명>)를 만날 때 호출됩니다.
    // =========================================================
    // 매개변수 설명:
    //   uri        : 네임스페이스 URI (이 예제에서는 사용 안 함)
    //   localName  : 네임스페이스 없는 로컬 태그 이름 (이 예제에서는 사용 안 함)
    //   qName      : 실제 사용하는 태그 이름 ("student", "name" 등)
    //   attributes : 해당 태그의 속성 목록 (<student id="1">에서 id="1" 부분)
    // =========================================================
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        // 현재 처리 중인 태그 이름을 저장해 둡니다.
        // characters() 메서드에서 이 값을 보고 어느 필드에 데이터를 저장할지 결정합니다.
        currentElement = qName;

        // <student> 태그를 만났을 때: 새 학생 데이터 초기화
        if (qName.equals("student")) {
            studentCount++;

            // attributes.getValue("id")
            //   attributes 목록에서 "id"라는 이름의 속성값을 꺼냅니다.
            //   <student id="1"> 에서 "1"을 반환합니다.
            currentId = attributes.getValue("id");

            // 새 학생 시작이므로 이전 데이터 초기화
            currentName  = "";
            currentAge   = "";
            currentMajor = "";
            currentGrade = "";
            currentEmail = "";
        }
    }

    // =========================================================
    // characters() - 태그 사이의 텍스트를 만날 때 호출됩니다.
    // =========================================================
    // 매개변수 설명:
    //   ch     : 문자 배열 전체 (XML 전체 버퍼일 수 있어 직접 사용하지 않습니다)
    //   start  : ch 배열에서 현재 텍스트가 시작하는 인덱스
    //   length : 현재 텍스트의 길이
    //
    // 주의: characters()는 한 번에 텍스트 전체를 주지 않을 수도 있습니다.
    //   즉, 같은 태그의 텍스트에 대해 여러 번 호출될 수 있습니다.
    //   이 예제처럼 짧은 텍스트라면 보통 한 번에 오지만,
    //   대용량이라면 누적(+=)해야 합니다.
    // =========================================================
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        // new String(ch, start, length) : ch 배열의 start 위치부터 length 길이만큼 문자열로 변환
        String value = new String(ch, start, length).trim();

        // 빈 문자열(공백, 줄바꿈 등)은 무시합니다.
        // XML에서 들여쓰기나 줄바꿈도 텍스트 노드로 전달되기 때문입니다.
        if (value.isEmpty()) return;

        // currentElement를 확인해서 적절한 필드에 값을 저장합니다.
        // switch 문으로 가독성 있게 분기합니다.
        switch (currentElement) {
            case "name"  -> currentName  = value;
            case "age"   -> currentAge   = value;
            case "major" -> currentMajor = value;
            case "grade" -> currentGrade = value;
            case "email" -> currentEmail = value;
            // "students", "student" 등 다른 태그의 텍스트는 무시합니다.
        }
    }

    // =========================================================
    // endElement() - 닫는 태그(</태그명>)를 만날 때 호출됩니다.
    // =========================================================
    // 매개변수 설명: startElement()와 동일하나 attributes는 없습니다.
    //
    // </student>를 만나면 한 학생의 데이터가 모두 모였다는 뜻이므로,
    // 여기서 출력합니다.
    // =========================================================
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // </student> 태그를 만났을 때: 수집한 데이터를 출력합니다.
        if (qName.equals("student")) {
            System.out.println("[ 학생 #" + currentId + " ]");
            System.out.println("  이름   : " + currentName);
            System.out.println("  나이   : " + currentAge + "세");
            System.out.println("  전공   : " + currentMajor);
            System.out.println("  학년   : " + currentGrade + "학년");
            System.out.println("  이메일 : " + currentEmail);
            System.out.println();
        }

        // 태그가 닫혔으므로 currentElement를 비워둡니다.
        // 이렇게 하지 않으면 태그 사이의 공백 문자가 characters()로 전달될 때
        // 이전 태그 이름이 남아 있어 잘못된 필드에 저장될 수 있습니다.
        currentElement = "";
    }

    // =========================================================
    // startDocument() - XML 문서 파싱이 시작될 때 한 번 호출됩니다.
    // =========================================================
    @Override
    public void startDocument() throws SAXException {
        // 파싱 시작 알림 (선택사항)
        System.out.println("SAX 파싱을 시작합니다...\n");
    }

    // =========================================================
    // endDocument() - XML 문서 파싱이 끝났을 때 한 번 호출됩니다.
    // =========================================================
    @Override
    public void endDocument() throws SAXException {
        // 파싱 종료 알림 및 요약 (선택사항)
        System.out.println("SAX 파싱 완료. 총 " + studentCount + "명의 학생 데이터를 읽었습니다.");
    }
}
