import React, { useState } from "react";
import { Button, Card, Avatar, Input,Modal } from "antd";
import { UserOutlined } from "@ant-design/icons";
import {useNavigate} from 'react-router-dom';
import {useDispatch} from "react-redux"
import { useAuth } from "../../hooks/useAuth";


const PersonalAccount = ()=>{

    const dispatch = useDispatch();

    const user = useAuth();

   
    const [isEditing, setIsEditing] = useState(false);
  
    const [isModalVisible, setIsModalVisible] = useState(false);
    const navigate = useNavigate();

  
    const handleEditClick = () => {
      setIsEditing(true);
    };
  
    const handleSaveClick = () => {
      setIsEditing(false);
      // Ваш код для сохранения обновленного имени пользователя
    };

    const handleDeleteClick = () => {
        setIsModalVisible(true);
      };

    const handleInputChange = (e) => {
      //setUsername(e.target.value);
    };

    const handleModalOk = () => {
        setIsModalVisible(false);
        // Ваш код для удаления аккаунта
        navigate("/registration") // Перенаправление на страницу регистрации
      };
    
      const handleModalCancel = () => {
        setIsModalVisible(false);
      };
    return (
        <Card>
        <Avatar size={64} icon={<UserOutlined />} />
        {isEditing ? (
          <Input value={user.username} onChange={handleInputChange} />
        ) : (
          <h2>{user.username}</h2>
        )}
        <p>Email: {user.email}</p>
        {isEditing ? (
          <Button type="primary" onClick={handleSaveClick}>Save</Button>
        ) : (
          <Button type="primary" onClick={handleEditClick}>Edit Profile</Button>
        )}
        <Button danger onClick={handleDeleteClick}>Delete Account</Button>
        <Modal
        title="Confirmation"
        open={isModalVisible}
        onOk={handleModalOk}
        onCancel={handleModalCancel}
      >
        <p>Are you sure you want to delete your account?</p>
      </Modal>
      </Card>
    );
}
export {PersonalAccount};