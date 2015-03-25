LogbackBandwidthFilter
======

Limit amount of log messages per second. Usage 
```
<appender ...>
  ...
  <filter class="ivan.mykhailov.utils.LogbackBandwidthFilter">
    <value>50</value>
  </filter>
</appender>
```
