###### Rabbitmq发送端：

~~~properties
@Component
public class MailProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMailMq(){
        String message = "this is a mial message from shop.knowledge.mail.msg";
        amqpTemplate.convertAndSend("shop.knowledge","shop.knowledge.mail.msg", message);
    }
}
~~~

###### 接收端：

~~~java
@Component
@RabbitListener(queues = "ShopKnowledgeMailQueue")
public class MailConsumer {

    @RabbitHandler
    public void mailConsumer(String content){
        System.out.println("接收到对应mailmq： " + content);
    }

}
~~~



