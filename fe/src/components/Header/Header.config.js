import {Avatar} from 'antd';
import {UserOutlined} from '@ant-design/icons';
import {NavLink} from "react-router-dom";
import {space,verticalCenter,logoStyle} from "./Header.style.js";

const items = () => [
    {
        label: (
            <NavLink to="/home" style={logoStyle}>Tabs generator</NavLink>
        ),
        key: 'tabs',
        style: verticalCenter

    },
    {
        label: (
            <NavLink to="/home">home</NavLink>
        ),
        key: 'home',
        style: verticalCenter
    },
    {
        label: (
            <NavLink to="/generate-tabs" >Generate tabs</NavLink>
        ),
        key: 'tabs_generator',
        style: verticalCenter

    },
    {
        label: (
            <span></span>
        ),
        key: 'space',
        style: space
       
    },
    {
        label:(
            <NavLink to = "/login">login</NavLink>

        ),
        key:'login',
        style: verticalCenter
    },
    {
        label: (
            <NavLink to="/user/:userId">
                <Avatar size="small" icon={<UserOutlined />}/>
                <span> </span>
            </NavLink>
        ),
        key: 'avatar',
        style: verticalCenter
    }
]

export { items }