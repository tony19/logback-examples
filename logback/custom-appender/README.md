This demonstrates how to create a custom logback appender and use it in logback.xml.

Running the main app will produce the following output:
```
17:45:56,944 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
17:45:56,945 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
17:45:56,945 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/Users/tony/Developer/src/logback-examples_2/logback/custom-appender/target/classes/logback.xml]
17:45:57,055 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [com.github.tony19.example.customappender.CustomAppender]
17:45:57,056 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [custom]
17:45:57,078 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to INFO
17:45:57,078 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [custom] to Logger[ROOT]
17:45:57,079 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
17:45:57,082 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@43ecf5e7 - Registering current configuration as safe fallback point
in append(). config.capacity=128
```
