import {LockOutlined, UserOutlined,HomeOutlined} from '@ant-design/icons';
import {Button, Card, Form, Input, Typography,notification} from 'antd';
import {useNavigate} from 'react-router-dom';
import {useDispatch} from "react-redux"
import "./style.css";
import LayOut from '../../components/LayOut/LayOut';
import { getUser } from '../../services/getUser';
import { login } from '../../store/actionCreators/login';

const {Title,Text} = Typography;

const Login = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch(); 

  const onFinish = (values) => {
    handleLogin(values.email,values.password)
  };

  const handleLogin = async (email,password) =>{
    try{
      const response = await getUser(email,password);
      const user = response.data;
      console.log(user)
      dispatch(login(user))
      navigate("/home") 
      notification.open({
        message:"OK",
        description:"Вы успешно авторизовались",
        placement:"topLeft",
        type:"success"
    });
    
    }catch(error){
      notification.open({
        message:"Ошибка",
        description:"Такого пользователя не сущетсвует",
        placement:"topRight",
        type:"error"
    });

    }

  }

  const onClickChangePassword = () => {
    navigate("/change-password");
  };
  const onClickRegistration = () => {
    navigate("/registration")
    };

  const onClickHome = () => {
      navigate("/home");
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
      <Form.Item>
              <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                <div>
                  <Title level={2}>Генератор табулатуры</Title>
                  <Text type="secondary">
                    Войти в сервис для генерации табулатуры
                  </Text>
                </div>
                <Button type="link" onClick={onClickHome} icon={<HomeOutlined />} />
              </div>
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
      <Form.Item>
                <Button type="link" onClick={onClickChangePassword}>Сменить пароль</Button>
              </Form.Item>
      
    </Form>
        </Card>
        </div>
    </LayOut> 
  );
};

export {Login};