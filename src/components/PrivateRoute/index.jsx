import React, {useContext} from "react";
import {Route, Redirect} from 'react-router-dom'

import {DataSessionContext} from '../../utils'


const PrivateRoute = ({ component: Component, ...rest }) => {
    const manageSession = useContext(DataSessionContext);
    return (
        <Route {...rest}>
            { props => manageSession.getUID() ? <Component {...props} /> : <Redirect to='/login' /> }
        </Route>
    )
};

export default PrivateRoute