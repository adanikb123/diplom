import {Avatar} from 'antd';
import {UserOutlined} from '@ant-design/icons';
import {NavLink} from "react-router-dom";
import "./style.css"
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
                <NavLink to="/home" className={'logostyle'} >Генератор табулатуры</NavLink>
              ),
              key: 'tabs',
            },
            {
              label: (
                <NavLink to="/home"className={'vertical_center'}>На главную</NavLink>
              ),
              key: 'home',
            },
            {
              label: (
                <NavLink to="/generate-tabs"className={'vertical_center'}>Сгенерировать табулатуры</NavLink>
              ),
              key: 'tabs_generator',
            },
            {
              label: (
              (user.role == "ADMIN") ?(
                  <NavLink to="/users"className={'vertical_center'}>Пользователи</NavLink>
                ):(
                   <></>
                )
              ),
              key: 'users',
            },
            {
              label: (
                <span className='space'></span>
              ),
              key: 'space',
            },
            {
              label: (
                user.isAuth ? (
                  <NavLink to="/login" onClick={logOut} className={'vertical_center'}>Выйти из аккаунта</NavLink>
                ) : (
                  <NavLink to="/login"className={'vertical_center'}>Войти в аккаунт</NavLink>
                )
              ),
              key: 'login',
            },
            {
              label: (
                <NavLink to={`/user/${user.id}`}className={'verticalcenter'}>
                  <Avatar size="small" icon={<UserOutlined />} />
                  <span> </span>
                </NavLink>
              ),
              key: 'avatar',
            }
          ]
    );
  }



export { HeaderConf };