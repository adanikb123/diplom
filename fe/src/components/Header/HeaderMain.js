import React from 'react';
import { Layout, Menu} from 'antd';
import './style.css';
import {HeaderConf} from './Header.config.js';
const { Header, Footer } = Layout;
const HeaderMain = () => {

  return (
    <Layout>
      <Header
    className='header'
      >
        <Menu
          selectable = {false}
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          items={HeaderConf()}
          style={{
            flex: 1,
            minWidth: 0,
          }}
        />
      </Header>
      <Footer
      className='footer'
      >
        Diplom ©{new Date().getFullYear()} Created by Strushko Danila
      </Footer>
    </Layout>
  );
};
export {HeaderMain};