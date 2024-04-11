import React from 'react';

import { useLocation } from 'react-router-dom';
import { HeaderMain } from '../Header';
import noHeader from '../../constants/noHeader';

const LayOut = ({ children }) => {
  const router = useLocation();

  const { pathname } = router;
  
  return (
    <div>
      <div className="flex flex-col h-screen">
        {noHeader.includes(pathname) ? null : <HeaderMain />}
        <main className="mb-auto">{children}</main>

      </div>
    </div>
  );
};

export default LayOut;
