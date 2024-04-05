import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Card, Form, Input, Typography} from 'antd';
import {useNavigate} from 'react-router-dom';
import "./style.css";
import LayOut from '../../components/LayOut/LayOut';

const {Title,Text} = Typography;

const Reg =() => {
    let navigate = useNavigate();

    const onFinish = (values) => {
      console.log('Received values of form: ', values);
      let path = '/home';
      navigate(path)
      };
    return (
      <LayOut >
          <div className='reg'>
      
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
          <Title level = {2}>Tabs Generator</Title>
              <Text type = "secondary">
                 Register in service for generating tabs
              </Text>
          </Form.Item>
          
        <Form.Item
          name="email"
          rules={[
            {
              required: true,
              message: "email is requided",
            },
          ]}
        >
          <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Email" />
        </Form.Item>
        <Form.Item
          name="userName"
          rules={[
            {
              required: true,
              message: "userName is requided",
            },
          ]}
        >
          <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="userName" />
        </Form.Item>
        <Form.Item
          name="password"
          rules={[
            {
              required: true,
              message: "password is requided"
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
              Register
          </Button> 
        </Form.Item>
  
        
      </Form>
          </Card>
          </div>
      </LayOut> 
    );


}


export {Reg};