ruleset {
	ruleset('rulesets/basic.xml')

	ruleset('rulesets/braces.xml')

	ruleset('rulesets/concurrency.xml')

	ruleset('rulesets/convention.xml') {
		exclude 'NoTabCharacter'
//		exclude 'TrailingComma'
//		exclude 'NoDef'
	}

	ruleset('rulesets/design.xml') {
		exclude 'NestedForLoop'
	}

	ruleset('rulesets/dry.xml') {
		exclude 'DuplicateStringLiteral'
//		exclude 'DuplicateNumberLiteral'
	}

	ruleset('rulesets/enhanced.xml')

	ruleset('rulesets/exceptions.xml') {
//		exclude 'CatchException'
	}

	ruleset('rulesets/formatting.xml') {
		exclude 'Indentation'

		SpaceAroundMapEntryColon {
			characterAfterColonRegex = /\s/
			characterBeforeColonRegex = /./
		}

//		SpaceAfterOpeningBrace {
//			ignoreEmptyBlock = true
//		}
//
//		SpaceBeforeClosingBrace {
//			ignoreEmptyBlock = true
//		}
	}

	ruleset('rulesets/generic.xml')

	ruleset('rulesets/groovyism.xml') {
//		exclude 'GStringExpressionWithinString'
	}

	ruleset('rulesets/imports.xml') {
//		MisorderedStaticImports {
//			comesBefore = false
//		}
	}

	ruleset('rulesets/logging.xml') {
//		exclude 'PrintStackTrace'
//		exclude 'Println'
	}

	ruleset('rulesets/naming.xml') {
//		exclude 'PackageName'
	}

	ruleset('rulesets/size.xml') {
//		exclude 'NestedBlockDepth'
		exclude 'AbcMetric'
//		exclude 'CyclomaticComplexity'
//		exclude 'MethodSize'
	}

	ruleset('rulesets/serialization.xml') {
//		exclude 'SerializableClassMustDefineSerialVersionUID'
	}

	ruleset('rulesets/security.xml') {
		exclude 'JavaIoPackageAccess'
	}

	ruleset('rulesets/unused.xml')

	ruleset('rulesets/unnecessary.xml') {
		exclude 'UnnecessaryReturnKeyword'
//		exclude 'ConsecutiveStringConcatenation'
		// spread *. pas encore disponible en jenkins dsl
//		exclude 'UnnecessaryCollectCall'
	}
}