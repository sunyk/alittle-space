### @JsonFormat(用于出参)

~~~java
@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")

@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
~~~

### @DatetimeFormat（用于入参）

~~~java
@DateTimeFormat(pattern = “yyyy-MM-dd HH:mm”) 
~~~

