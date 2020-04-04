import React from "react";

/**
 * Context React pour pour manipuler User
 * @type {React.Context<null>}
 */
const DataUserContext = React.createContext(null)
const DataSessionContext = React.createContext(null)

export {DataUserContext, DataSessionContext};