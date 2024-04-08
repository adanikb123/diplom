import {Avatar} from 'antd';
import {UserOutlined} from '@ant-design/icons';
import {NavLink} from "react-router-dom";
import {space,verticalCenter,logoStyle} from "./Header.style.js";

const items = () => [
    {
        label: (
            <NavLink to="/home" style={logoStyle}>Генератор табулатуры</NavLink>
        ),
        key: 'tabs',
        style: verticalCenter

    },
    {
        label: (
            <NavLink to="/home">На главную</NavLink>
        ),
        key: 'home',
        style: verticalCenter
    },
    {
        label: (
            <NavLink to="/generate-tabs" >Сгенерировать табулатуры</NavLink>
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
            <NavLink to = "/login">Войти</NavLink>

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