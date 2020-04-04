import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import User, {DataUserContext, DataSessionContext, Session} from "./utils";

import * as serviceWorker from './serviceWorker';


ReactDOM.render(
    <React.StrictMode>
        <DataSessionContext.Provider value={Session}>
            <DataUserContext.Provider value={new User()}>
                <App />
            </DataUserContext.Provider>
        </DataSessionContext.Provider>
    </React.StrictMode>,
    document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
