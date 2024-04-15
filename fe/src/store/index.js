import {combineReducers} from "redux";
import {configureStore} from "@reduxjs/toolkit";
import {composeWithDevTools} from "@redux-devtools/extension";
import { persistStore, persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';

import { songReducer, songsReducer,userReducer, usersReducer } from "./reducers";
import { fileReducer } from "./reducers/fileReducer";

const persistConfig = {
    key: 'root',
    storage,
  };

const rootReducer = combineReducers({
    songs: songsReducer,
    song:songReducer,
    user: userReducer,
    users:usersReducer,
    file:fileReducer
  });

const persistedReducer = persistReducer(persistConfig, rootReducer);

export const store = configureStore({
    reducer:persistedReducer,
    devTools:composeWithDevTools
});

export const persistor = persistStore(store);


window.addEventListener('beforeunload', (event) => {
  event.preventDefault(); 

  persistor.purge();
});