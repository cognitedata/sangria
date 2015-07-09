package sangria.parser

import org.parboiled2.{ParseError, ParserInput, Parser}

case class SyntaxError(parser: Parser, input: ParserInput, originalError: ParseError) extends Exception(originalError) {
  lazy val formattedError = parser.formatError(originalError)
  lazy val message = s"Syntax error while parsing GraphQL query. $formattedError"
}