grammar Typescript;

import TypescriptRules;

program: defineStatement ;

defineStatement: ( theStatement+ )? ;

theStatement: ( ( importStatement | defineVariableStatement | invokeStatement | variableSelfAction ) isEndingLine ) | ( defineFunction | ifStatement );

importStatement: Import leftBrace identifier ((Comma identifier)+)? rightBrace From String;

defineFunction: Function identifier leftParen paramList? rightParen (Colon argType)? leftBrace defineStatement rightBrace ;

defineVariableStatement: isDefineField? variableName ((Colon argType (leftBracket rightBracket)?)? (assignment ( resultPresenting | assignmentIdentifier ))?)? ;

resultPresenting: constant | identifier | fullName | resultingStatement ;

resultingStatement: invokeStatement | newInstanceStatement | calculateStatement | anonymousObject | callbackFunction | variableSelfAction | ofList ;

ofList: leftBracket ( Comma? resultPresenting Comma?)* rightBracket ;

ifStatement: If
             leftParen (
              resultPresenting   |
              calculateStatement
             ) rightParen
             statementBlock
             (
              (
               elseIfStatement
              )                  |
              (
               elseStatement
              )
             ) ?
;

elseStatement: Else statementBlock ;

elseIfStatement: Else ifStatement ;

statementBlock: leftBrace (
                 defineStatement
                ) rightBrace
;

variableSelfAction: variableSelfDecrement | variableSelfIncrement ;

variableSelfDecrement: beforeDecrement? invokeAccess afterDecrement? ;

beforeDecrement: Decrement ;
afterDecrement: Decrement;

variableSelfIncrement: beforeIncrement? invokeAccess afterIncrement? ;

beforeIncrement: Increment ;
afterIncrement: Increment ;

callbackFunction: ( (leftParen callbackParamList? rightParen) | callbackParam ) CallbackAssigment leftBrace defineStatement rightBrace;

callbackParamList: callbackParam ( Comma callbackParam ) *;

callbackParam: identifier ( Colon argType )?;

anonymousObject: leftBrace ( anonymousObjectParamList ) rightBrace ;

anonymousObjectParamList: anonymousObjectParam + ;

anonymousObjectParam: identifier Colon resultPresenting Comma? ;

calculatableResultPresenting: calculateStatementWithParen | invokeStatement | newInstanceStatement | constant | identifier | fullName ;

calculateStatementWithParen: leftParen ( calculateLeftStatementWithParen ) rightParen extraCalculateStatement* ;

calculateLeftStatementWithParen: calculateStatement | calculatableResultPresenting ;

calculateStatement: (calculateLeft extraCalculateStatement* ) | (calculateStatementWithTotalParen extraCalculateStatement*) | calculateStatementWithParen ;

calculateStatementWithTotalParen: leftParen calculateLeft extraCalculateStatement* rightParen;

calculateLeft: calculatableResultPresenting ;

extraCalculateStatement: operator calculatableResultPresenting ;

returnStatement: Return resultPresenting ;

// xxx(param?)
invokeStatement: invokeObject leftParen invokeParamList? rightParen fluentInvokeStatement*;

invokeObject: invokeAccess + ;

invokeAccess: ( accessArray | accessElement ) ;

accessElement: ( Point? fullNameOrIdentifier ) ;

accessArray: ( accessElement leftBracket resultPresenting rightBracket ) ;

fluentInvokeStatement: point identifier leftParen invokeParamList? rightParen ;

newInstanceStatement: New identifier leftParen invokeParamList? rightParen ;

variableName: identifier | fullName ;

paramList: paramType (Comma paramType)? ;

paramType: identifier Colon argType ;

argType: identifier typedArgType? arrayArgType? ;

typedArgType: leftAngleBracket argType extraArgTypes* rightAngleBracket ;

extraArgTypes: Comma argType ;

arrayArgType: arrayDefinition* ;

arrayDefinition: leftBracket number? rightBracket ;

tokenList: validToken extraToken*;

validToken: (identifier | constant) ;

extraToken: Comma validToken ;

invokeParamList: validInvokeParam validExtraInvokeParam* ;

validInvokeParam: ( validToken | resultPresenting );

validExtraInvokeParam: Comma validInvokeParam?;

constant: ( String | number | Null | Undefined | bool);

assignmentIdentifier: identifier ;
