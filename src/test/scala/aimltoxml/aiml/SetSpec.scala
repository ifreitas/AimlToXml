/**
 * The MIT License (MIT)
 *
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

class SetSpec extends FlatSpec with Matchers {
    
//    it should "throws an exception when the index is 0" in {
//        intercept[IllegalArgumentException]{new aimltoxml.aiml.Set("","")}
//    }
//    it should "throws an exception when the index is negative" in {
//        intercept[IllegalArgumentException]{Set(-1)}
//    }
//    
    "#toXml" should "generate a valid XML (text)" in {
    	new AimlSet("collor",Text("blue")).toXml.toString should be((<set name="collor">blue</set>).toString)
    }
    it should "generate a valid XML (star)" in {
    	new aimltoxml.aiml.AimlSet("collor",Star(1)).toXml.toString should be((<set name="collor"><star index="1"/></set>).toString)
    }
}