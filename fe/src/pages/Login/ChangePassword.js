import { LockOutlined } from "@ant-design/icons";
import { Button, Card, Form, Input, Typography, notification } from "antd";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserByEmail } from "../../services/getUserByEmail";
import { useSelector,useDispatch } from "react-redux";
import { getUser } from "../../store/actionCreators/getUser";
import { logout } from "../../store/actionCreators/logout";
import { changePassword } from "../../services/changePassword";

const { Title, Text } = Typography;

const ChangePassword = () => {
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const user = useSelector(state=>state.user);
  const dispatch = useDispatch();

  const onFinish = async (values) => {
    const { password, confirmPassword } = values;

    if (password === confirmPassword) {
      await changePassword(user.id,password)
      notification.open({
        message: "Пароль изменен",
        description: "Ваш пароль успешно изменен",
        placement: "topLeft",
        type: "success"
      });
      navigate("/login");
    } else {
      notification.open({
        message: "Ошибка",
        description: "Пароли не совпадают",
        placement: "topRight",
        type: "error"
      });
    }
    dispatch(logout());
  };

  const validateEmail = (rule, value) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (value && !emailRegex.test(value)) {
      return Promise.reject("Некорректный email");
    }
    return Promise.resolve();
  };

  const onClickBack = () => {
    navigate("/login");
  };

  const handleSendEmail =async(e) =>{
    console.log(e.email);
    const response = await getUserByEmail(e.email)
    dispatch(getUser(response.data))
  }
  return (
    <Card style={{ width: 500 }}>
      {!user.id ? (
        <Form
          name="change_password_email"
          form={form}
          onFinish={handleSendEmail}
        >
          <Title level={3}>Смена пароля</Title>
          <Text>Введите ваш email, чтобы сбросить пароль:</Text>
          <Form.Item
            name="email"
            rules={[
              {
                required: true,
                message: "Email обязателен"
              },
              {
                validator: validateEmail
              }
            ]}
          >
            <Input
              prefix={<LockOutlined className="site-form-item-icon" />}
              placeholder="Email"
            />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit" >
              Отправить
            </Button>
          </Form.Item>
        </Form>
      ) : (
        <Form
          name="change_password"
          form={form}
          onFinish={onFinish}
        >
          <Title level={3}>Смена пароля для {user.name}</Title>
          <Form.Item
            name="password"
            rules={[
              {
                required: true,
                message: "Введите новый пароль"
              }
            ]}
          >
            <Input.Password
              prefix={<LockOutlined className="site-form-item-icon" />}
              placeholder="Новый пароль"
            />
          </Form.Item>
          <Form.Item
            name="confirmPassword"
            dependencies={["password"]}
            rules={[
              {
                required: true,
                message: "Подтвердите пароль"
              },
              ({ getFieldValue }) => ({
                validator(_, value) {
                  if (!value || getFieldValue("password") === value) {
                    return Promise.resolve();
                  }
                  return Promise.reject("Пароли не совпадают");
                }
              })
            ]}
          >
            <Input.Password
              prefix={<LockOutlined className="site-form-item-icon" />}
              placeholder="Подтвердите пароль"
            />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Изменить
            </Button>
          </Form.Item>
        </Form>
      )}
      <Button type="link" onClick={onClickBack}>
        Вернуться назад
      </Button>
    </Card>
  );
};

export { ChangePassword };