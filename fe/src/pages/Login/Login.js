import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Card, Form, Input, Typography} from 'antd';
import {useNavigate} from 'react-router-dom';
import "./style.css";
import LayOut from '../../components/LayOut/LayOut';

const {Title,Text} = Typography;

const Login = () => {
    let navigate = useNavigate();

  const onFinish = (values) => {
    console.log('Received values of form: ', values);
    let path = '/home';
    navigate(path)
    };
    const onClickRegistration = () => {
      navigate("/registration")
      };
  return (
    <LayOut >
        <div className='login'>
    
    <Card style = {{width: 500} }>

    <Form
      name="normal_login"
      className="login-form"
      initialValues={{
        remember: true,
      }}
      onFinish={onFinish}
    >
        <Form.Item >
        <Title level = {2}>Генератор табулатуры</Title>
            <Text type = "secondary">
               Войти в серивис для генерации
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
        name="password"
        rules={[
          {
            required: true,
            message: "пароль обязателен"
          },
        ]}
      >
        <Input.Password
          prefix={<LockOutlined className="site-form-item-icon" />}
          type="password"
          placeholder="Password"
        />
      </Form.Item>
      <Form.Item>
        <Button type="primary" htmlType="submit" className="login-form-button">
            Войти
        </Button> или
       <Button type="primary" htmlType="button" className="login-form-button" onClick={onClickRegistration} >
            Зарегистрироваться 
        </Button>
      </Form.Item>

      
    </Form>
        </Card>
        </div>
    </LayOut> 
  );
};

export {Login};