package aimltoxml.aiml

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class RandomSpec extends FlatSpec with Matchers {
    it should "throws an exception when no Options" in {
        intercept[IllegalArgumentException]{Random(None).toXml}
    }
    
    "#toXml" should "generate a valid XML (varargs)" in{
        val expectedXml = <random><li>Hi</li><li>Hey</li></random>
        Random(Some(Text("Hi")), Some(Text("Hey"))).toXml should be(expectedXml)
    }
    it should "generate a valid XML (list)" in{
    	val expectedXml = <random><li>Hi</li><li>Hey</li></random>
    	Random(Set[Option[RandomElement]](Some(Text("Hi")), Some(Text("Hey")))).toXml should be(expectedXml)
    }
    it should "generate a valid XML (li + srai)" in{
    	val expectedXml = <random><li>Hi</li><li><srai>Hey</srai></li></random>
    	Random(Some(Text("Hi")), Some(Srai(Text("Hey")))).toXml should be(expectedXml)
    }
}