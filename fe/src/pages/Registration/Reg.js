import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Card, Form, Input, Typography,notification} from 'antd';
import {useNavigate} from 'react-router-dom';
import {useDispatch} from "react-redux"
import "./style.css";
import LayOut from '../../components/LayOut/LayOut';
import { login } from '../../store/actionCreators/login';
import { createUser } from '../../services/createUser';

const {Title,Text} = Typography;

const Reg =() => {
    let navigate = useNavigate();
    const dispatch = useDispatch(); 

    const onFinish = (values) => {
    
      handleReg(values.email,values.name,values.password);
    };
    const handleReg = async(email,name,password)=>{
      try{
        const response = await createUser(email,name,password);
        const user = response.data;
        console.log(user);
        dispatch(login(user));
        navigate("/home");
        notification.open({
          message:"OK",
          description:"Вы успешно зарегистрировались",
          placement:"topLeft",
          type:"success"
      });
      }catch(error){
        notification.open({
          message:"Ошибка",
          description:"Не удалось зарегестрировать аккаунт",
          placement:"topRight",
          type:"error"
      });

      }
      
    }
    return (
      <LayOut >
          <div className='reg'>
      
      <Card style = {{width: 500} }>
  
      <Form
        name="normal-registration"
        className="registration-form"
        initialValues={{
          remember: true,
        }}
        onFinish={onFinish}
      >
          <Form.Item >
          <Title level = {2}>Генератор табулатуры</Title>
              <Text type = "secondary">
                 Регистрация в сервисе для генерации табулатуры
              </Text>
          </Form.Item>
          
        <Form.Item
          name="email"
          rules={[
            {
              required: true,
              message: "email обязателен",
            },
          ]}
        >
          <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Email" />
        </Form.Item>
        <Form.Item
          name="name"
          rules={[
            {
              required: true,
              message: "userName обязателен",
            },
          ]}
        >
          <Input prefix={<UserOutlined/>} placeholder="userName" />
        </Form.Item>
        <Form.Item
          name="password"
          rules={[
            {
              required: true,
              message: "пароль обязателен"
            },
          ]}
        >
          <Input.Password
            prefix={<LockOutlined />}
            type="password"
            placeholder="Password"
          />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit">
              Зарегистрироваться
          </Button> 
        </Form.Item>
  
        
      </Form>
          </Card>
          </div>
      </LayOut> 
    );


}


export {Reg};