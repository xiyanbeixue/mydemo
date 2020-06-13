## Springboot demo
- 从头搭建springboot项目，集成swagger2的restful api风格;
- mysql数据库，mybatils

# ApiResult 返回参数封装
- 200：操作成功
- 201：数据操作异常（服务层抛出自定义异常CustomException）
- 202：参数校验异常（控制层注解验证@Valid）
- 400：运行时异常
- 500：系统未知异常