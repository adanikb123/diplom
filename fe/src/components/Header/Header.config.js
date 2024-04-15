import {Avatar} from 'antd';
import {UserOutlined} from '@ant-design/icons';
import {NavLink} from "react-router-dom";
import {space,verticalCenter,logoStyle} from "./Header.style.js";
import{useDispatch} from "react-redux";
import { logout } from '../../store/actionCreators/logout';
import { useAuth } from '../../hooks/useAuth.js';


const HeaderConf = () => {
    const user = useAuth();
    const dispatch = useDispatch();

    const logOut =()=>{
        dispatch(logout());
    }
  
    return (
        [
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
                <NavLink to="/generate-tabs">Сгенерировать табулатуры</NavLink>
              ),
              key: 'tabs_generator',
              style: verticalCenter
            },
            {
              label: (
              (user.role == "ADMIN") ?(
                  <NavLink to="/users">Пользователи</NavLink>
                ):(
                   <></>
                )
              ),
              key: 'users',
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
              label: (
                user.isAuth ? (
                  <NavLink to="/login" onClick={logOut}>Выйти из аккаунта</NavLink>
                ) : (
                  <NavLink to="/login">Войти в аккаунт</NavLink>
                )
              ),
              key: 'login',
              style: verticalCenter
            },
            {
              label: (
                <NavLink to={`/user/${user.id}`}>
                  <Avatar size="small" icon={<UserOutlined />} />
                  <span> </span>
                </NavLink>
              ),
              key: 'avatar',
              style: verticalCenter
            }
          ]
    );
  }



export { HeaderConf };