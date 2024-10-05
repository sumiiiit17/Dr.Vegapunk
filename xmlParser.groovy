import groovy.xml.XmlParser
import groovy.xml.XmlUtil

// Load the XML content from a file
def xmlContent = new File('Test01.xml').text
def parser = new XmlParser()
def bookstore = parser.parseText(xmlContent)

// Print the class type of the parsed XML (should be Node or NodeList)
println(bookstore.getClass())
println(XmlUtil.serialize(bookstore))
println("-------------------------------")
// Add a new book
def newBook = bookstore.appendNode('book', [category: 'programming'])
newBook.appendNode('title', 'Programming Groovy')
newBook.appendNode('author', 'Venkat Subramaniam')

// Print the updated XML
println(XmlUtil.serialize(bookstore))