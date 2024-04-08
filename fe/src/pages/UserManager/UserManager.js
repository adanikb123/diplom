import { Table, Input, Select,Button,notification } from "antd";
import React, { useState } from "react";
import "./style.css"

const { Option } = Select;
const UserManager =()=> {
    const [users, setUsers] = useState(
        [
            {
                id: 1,
                username: "johnsmith",
                email: "johnsmith@example.com",
                role: "USER"
            },
            {
                id: 2,
                username: "janedoe",
                email: "janedoe@example.com",
                role: "ADMIN"
            },
            {
                id: 3,
                username: "alexander",
                email: "alexander@example.com",
                role: "USER"
            }
        ]
    )
    const columns = [
        {
          title: "Username",
          dataIndex: "username",
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
    setUsers((prevState) =>
      prevState.map((user) =>
        user.id === userId ? { ...user, username: value } : user
      )
    );
  };

  const handleRoleChange = (userId, value) => {
    setUsers((prevState) =>
      prevState.map((user) =>
        user.id === userId ? { ...user, role: value } : user
      )
    );
  };
  const handleSave = ()=>{
    notification.open({
        message:'Данные успешно сохраненны',
        placement:"topRight",
        type:"success"
    });
  }
    return (
        <div>
            <Table dataSource={users} columns={columns} bordered = {true} rowClassName="table" className="table" />

            <Button type="primary" onClick={handleSave} className="saveButton">
                    Сохранить
            </Button>
        </div>
    )
}

export {UserManager};