import  { useState,useEffect } from "react";
import { Button, Card, Avatar, Input,Modal,notification,Typography ,Table} from "antd";
import { UserOutlined } from "@ant-design/icons";
import {useNavigate,Link} from 'react-router-dom';
import {useDispatch,useSelector} from "react-redux"
import { useAuth } from "../../hooks/useAuth";
import { updateUserName } from "../../store/actionCreators/updateUserName";
import { updateUser } from "../../services/updateUser";
import {logout} from "../../store/actionCreators/logout"
import { getAllUsersSongs } from "../../services/getAllUsersSongs";
import { getSongs } from "../../store/actionCreators/getSongs";
import { clearSongs } from "../../store/actionCreators/clearSongs";
import axios from "axios";
import { deleteUser } from "../../services/deleteUser";


const PersonalAccount = ()=>{

    const pageSize = 5;

    const dispatch = useDispatch();

    const user = useAuth();

    const songs = useSelector(state=>state.songs.songs)
    const currentPage = useSelector(state=>state.songs.currentPage)
    const totalElements = useSelector(state=>state.songs.totalElements)

   
    const [isEditing, setIsEditing] = useState(false);
  
    const [isModalVisible, setIsModalVisible] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
      const fetchData = async () => {
        dispatch(clearSongs());
        const response = await getAllUsersSongs(0, pageSize,user);
        const {number,totalElements,content} = response.data;
        const songsArray = content.map(item => item.song);
        dispatch(getSongs(songsArray,number,totalElements));
 
      };
      fetchData();
    }, [dispatch]);
  
    const handleEditClick = () => {
      setIsEditing(true);
    };
  
    const handleSaveClick = async () => {
      setIsEditing(false);
      await updateUser(user,user.token);
      notification.open({
        message:"OK",
        description:"Вы поменяли имя",
        placement:"bottomLeft",
        type:"success"
    });
    };

    const handleDeleteClick = async () => {
        setIsModalVisible(true);
        await deleteUser(user.id,user.token)
        dispatch(logout)
      };

    const handleInputChange = (e) => {
        dispatch(updateUserName(e.target.value)); 
      };
  

    const handleModalOk = () => {
        setIsModalVisible(false);
        dispatch(logout())
        navigate("/registration") // Перенаправление на страницу регистрации
      };
    
      const handleModalCancel = () => {
        setIsModalVisible(false);
      };


      const handlePageChange= async(page)=>{
        const response = await getAllUsersSongs(page-1, pageSize,user);
        const {number,totalElements,content} = response.data;
        const songsArray = content.map(item => item.song);
        dispatch(getSongs(songsArray,number,totalElements));
      }
  
      const columns = [
        {
          title: "Автор",
          dataIndex: "author",
          key: "author",
        },
        {
          title: "Название песни",
          dataIndex: "name",
          key: "name",
          render: (text, record) => (
            <Link to={`/song/${record.id}`}>{text}</Link>
          ),
        },
        {
          title: "Название инструмента",
          key: "tabs",
          render: (text, record) => (
            <>
              {record.tabs.map((tab) => (
                <div key={tab.id}>
                    <a href={process.env.PUBLIC_URL + tab.url} target="_blank" rel="noopener noreferrer">
              {tab.instrumentName}
            </a>
                </div>
              ))}
            </>
          ),
        },
      ];
    return (
        <Card>
        <Avatar size={64} icon={<UserOutlined />} />
        {isEditing ? (
          <Input value={user.name} onChange={handleInputChange} />
        ) : (
          <h2>{user.name}</h2>
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
      <Typography.Title level={3}>Добавленные вами песни</Typography.Title>
      <Table 
             rowClassName="myRow"
             columns={columns} 
             dataSource={songs} 
             bordered={true}
             pagination={{ 
              total:totalElements,
              current: currentPage+1,
              pageSize,
              onChange:handlePageChange 
            }} />   
      </Card>
    );
}
export {PersonalAccount};