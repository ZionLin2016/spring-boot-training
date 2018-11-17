## SpringBoot Schedule 整合演示项目

定时任务非常简单，只需要写个配置类，然后定义定时任务类，使用注解定义某个方法定期执行

``` java
@Scheduled(cron = "0 23 16 * * ?")
public void checkState() {
    //doSomethings
}
```



