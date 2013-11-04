/**
 *
 * The MIT License (MIT)
 * Copyright (c) 2013 Israel Freitas -- ( gmail => israel.araujo.freitas)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package aimltoxml.aiml

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class TopicSpec extends FlatSpec with Matchers {

    it should "throws an exception when no name" in {
        intercept[IllegalArgumentException] { Topic(null, Set.empty[Category]) }
    }
    it should "throws an exception when name is empty" in {
        intercept[IllegalArgumentException] { Topic("", Set.empty[Category]) }
    }

    "#toXml" should "throws an exception when categories is empty" in {
        intercept[IllegalArgumentException] { Topic("aTopic", Set.empty[Category]).toXml }
    }
    it should "generate a valid XML (list)" in {
        val xml = Topic("aTopicName", Category("hi", Set(Text("hello")))).toXml
        (xml \ "@name").toString() should be ("aTopicName")
        (xml \ "category").size should be(1)
    }
    it should "generate a valid XML (varargs)" in {
        val xml = Topic("aTopicName", Category("hi", Set(Text("hello")))).toXml
        (xml \ "@name").toString() should be("aTopicName")
        (xml \ "category").size should be(1)
    }
    it should "generate an XML with the same amount of Categories" in {
        val category1 = Category("hi", Set(Text("hello")))
        val category2 = Category("how are you", Set(Text("I'm fine. And you?")))
        val category3 = Category("Me too", Set(Text("good")))
        val topic = Topic("aTopicName", category1, category2, category3)

        val xml = topic.toXml
        (xml \ "category").size should be(3)
    }

}
