require 'rouge' unless defined? ::Rouge.version

# https://github.com/rouge-ruby/rouge/wiki/List-of-tokens
module Rouge; module Themes
  class KodeinDark < CSSTheme
    name 'kodein-dark'

    purple050 = '#F7EEF6'
    purple100 = '#E8C7E3'
    purple200 = '#D0A0CF'
    purple300 = '#BE72B3'
    purple400 = '#9E4994'
    purple500 = '#7A2A71'
    purple600 = '#480F40'
    purple700 = '#360A30'
    purple800 = '#250821'
    purple900 = '#11030E'
    purple950 = '#090108'

    orange050 = '#FEF2EF'
    orange100 = '#FDDDD6'
    orange200 = '#FAC0B0'
    orange300 = '#F0A698'
    orange400 = '#EC7A5C'
    orange500 = '#EF5E36'
    orange600 = '#E84420'
    orange700 = '#C43417'
    orange800 = '#9B2510'
    orange900 = '#6E180A'
    orange950 = '#4A0E05'


    style Text,                      {}

    style Comment,                   { fg: orange600 }

    style Error,
          Generic::Error,            { fg: '#82071e', bg: '#f6f8fa' }

    style Str,
          Str::Char,
          Literal,
          Literal::String,
          Literal::String::Backtick,
          Num,                       { fg: purple300 }

    style Literal::String::Interpol, { fg: purple100 }

    style Keyword,
          Keyword::Constant,
          Operator,
          Operator::Word,
          Name::Attribute,
          Name::Builtin,
          Name::Builtin::Pseudo,
          Name::Tag,                 { fg: purple300, bold: true }

    style Name::Class,               { fg: orange300 }

    style Generic::Lineno,           { fg: purple400 }

  end
end ; end
