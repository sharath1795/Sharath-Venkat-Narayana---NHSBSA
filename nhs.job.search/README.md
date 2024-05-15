{\rtf1\ansi\ansicpg1252\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 HelveticaNeue;\f2\fnil\fcharset0 HelveticaNeue-Medium;
\f3\fnil\fcharset0 .AppleSystemUIFontMonospaced-Regular;\f4\fswiss\fcharset0 Helvetica-Bold;\f5\fnil\fcharset0 Menlo-Regular;
}
{\colortbl;\red255\green255\blue255;\red24\green26\blue30;\red255\green255\blue255;\red24\green26\blue30;
}
{\*\expandedcolortbl;;\cssrgb\c12157\c13725\c15686;\cssrgb\c100000\c100000\c100000;\cssrgb\c12157\c13725\c15686;
}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid1\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs32 \cf0 Table of Contents\
1. About the Project\
2. Writing a test\
3. Tools used\
4. How to run the tests\
\
About the Project
\fs24 \
\pard\pardeftab720\sa320\partightenfactor0

\f1\fs32 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Automation Testing Using Java\
selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.\'a0\
\pard\pardeftab720\sl450\sa320\partightenfactor0

\f2\b\fs36 \cf2 Writing a test\
\pard\pardeftab720\sa320\partightenfactor0

\f1\b0\fs32 \cf2 The cucumber features goes in the\'a0
\f3\fs27\fsmilli13600 features
\f1\fs32 \'a0library and should have the ".feature" extension.\
You can start out by looking at\'a0
\f3\fs27\fsmilli13600 features/JobSearchSortedResults.feature
\f1\fs32 . You can extend this feature or make your own features and glue them to the step definitions glue code.\

\f4\b\fs36 \cf0 \cb1 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 Tools used\
\pard\pardeftab720\partightenfactor0

\f5\b0\fs24 \cf0 selenium-java 4.11.0\
junit 4.12\
cucumber-java 7.16.1\
webdrivermanager 5.8.0
\f4\b\fs36 \
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f1\b0\fs32 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
\pard\pardeftab720\sl450\sa320\partightenfactor0

\f2\b\fs36 \cf2 Running the test\
\pard\pardeftab720\sa320\partightenfactor0

\f1\b0\fs32 \cf2 Go to your project directory from terminal and hit following commands\
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f3\fs27\fsmilli13600 \cf2 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	\uc0\u8226 	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 mvn test (defualt will run on chrome and firefox browsers)
\f1\fs32 \cb1 \
\ls1\ilvl0
\f3\fs27\fsmilli13600 \cb3 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	\uc0\u8226 	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 mvn test \'93-Dcucumber.options=\'93--tags @chrome\'94 \cf4 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 (to use only Chrome browser)\
\ls1\ilvl0
\f1\fs32 \cf2 \kerning1\expnd0\expndtw0 {\listtext	\uc0\u8226 	}
\f3\fs27\fsmilli13600 \cf4 \expnd0\expndtw0\kerning0
mvn test \'93-Dcucumber.options=\'93--tags @firefox\'94 (to use only Firefox browser)\
\pard\tx566\pardeftab720\partightenfactor0

\f1\fs32 \cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
Cucumber reports are generated in HTML format under the Reports folder.\
\
}