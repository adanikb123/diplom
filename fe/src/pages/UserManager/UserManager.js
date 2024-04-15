import { Table, Input, Select,Button,notification } from "antd";
import {useSelector,useDispatch} from "react-redux";
import { getUsers } from "../../store/actionCreators/getUsers";
import { getAllUsers } from "../../services/getAllUsers";
import { refreshUsers } from "../../store/actionCreators/refreshUsers";
import { useEffect } from "react";
import "./style.css"
import { useAuth } from "../../hooks/useAuth";
import { updateUser } from "../../services/updateUser";

const { Option } = Select;
const UserManager =()=> {
  const pageSize = 3;
  const users = useSelector(state => state.users.users);
  const currPage = useSelector(state => state.users.currentPage)
  const total = useSelector(state => state.users.totalElements)
  const user = useAuth();
  const dispatch = useDispatch(); 
  

  useEffect(() => {
    const fetchData = async () => {
      const response = await getAllUsers(0, pageSize,user.token);
      const {number,totalElements,content} = response.data;
      console.log(content);
      dispatch(getUsers(content,number,totalElements));

    };
    fetchData();
  }, [dispatch]);
  

    const columns = [
        {
          title: "Username",
          dataIndex: "name",
          key: "username",
          render: (text, record) => (
            <Input
              value={text}
              onChange={(e) => handleUsernameChange(record.id, e.target.value)}
            />
          ),
        },
        {
            title: "email",
            dataIndex: "email",
            key: "email",
        },
        {
          title: "Role",
          dataIndex: "role",
          key: "role",
          render: (text, record) => (
            <Select
              value={text}
              onChange={(value) => handleRoleChange(record.id, value)}
              className='select'
              dropdownStyle = {{width:'auto'}}
      
            >
              <Option value="USER">User</Option>
              <Option value="ADMIN">Admin</Option>
            </Select>
          ),
        },
      ];
const handleUsernameChange = (userId, value) => {
  const updatedUsers = users.map(user => {
    if (user.id == userId) {
      return {
        ...user,
        name: value
      };
    }
    return user;
  });
    dispatch(refreshUsers(updatedUsers));
  };

  const handleRoleChange = (userId, value) => {
    const updatedUsers = users.map(user => {
      if (user.id == userId) {
        return {
          ...user,
          role: value
        };
      }
      return user;
    });
      dispatch(refreshUsers(updatedUsers));

  };
  const handleSave = async()=>{
    for (const targetUser of users) {
      await updateUser(targetUser, user.token);
    }
  
    notification.open({
        message:'Данные успешно сохраненны',
        placement:"topRight",
        type:"success"
    });
  }

  const handlePageChange= async(page)=>{
    const response = await getAllUsers(page-1, pageSize,user.token);
    const {number,totalElements,content} = response.data;
    dispatch(getUsers(content,number,totalElements));
  }

    return (
        <div>
            <Table 
            dataSource={users}
            columns={columns} 
            bordered = {true} 
            rowClassName="table" 
            className="table"
            pagination={{ 
                total:total,
                current: currPage+1,
                pageSize,
                onChange:handlePageChange 
              }}  />

            <Button type="primary" onClick={handleSave} className="saveButton">
                    Сохранить
            </Button>
        </div>
    )
}

export {UserManager};