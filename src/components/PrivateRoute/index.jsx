import React, {useContext} from "react";
import {Route, Redirect} from 'react-router-dom'

import {DataSessionContext} from '../../utils'


const PrivateRoute = ({ component: Component, ...rest }) => {
    const manageSession = useContext(DataSessionContext);
    return (
        <Route
            {...rest}
            render={
                props => manageSession.getUID() ?
                    <Component {...props} /> :
                    <Redirect to={{ pathname: '/login' }} />
            }
        />
    )
};

export default PrivateRoute