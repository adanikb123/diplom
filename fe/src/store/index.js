import {combineReducers} from "redux"
import {configureStore} from "@reduxjs/toolkit";
import {composeWithDevTools} from "@redux-devtools/extension"

import { songReducer,userReducer } from "./reducers";




export const store = configureStore({
    reducer:{
        song: songReducer,
        user: userReducer
    },
    devTools:composeWithDevTools
});


