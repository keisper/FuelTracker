/*import React, {useState} from 'react';
import './App.scss';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";

const makePage = name => (
    <div>
        <h3>{name}</h3>
        <p>This page is {name} page.</p>
    </div>
)

const Contact = () => makePage("Contact")
const About = () => makePage("About")
const Home= () => {
    const [customers, setCustomers] = useState([
        {id: 1, name: "Customer 1"},
        {id: 2, name: "Customer 2"}
    ])
    const handleDelete = id => {
        const keep = [...customers]
        const index = keep.findIndex(i => i.id === id)
        keep.splice(index, 1)
        setCustomers(keep)
    }
    const addCustomer = name => {
        const keep = [...customers]
        keep.push({id: keep.length + 1, name})
        setCustomers(keep)
    }
    return (
        <div>
            <h3>Customers' List</h3>
            <ul>{customers.map(elt => <Customer param={elt} handleDelete={() => handleDelete(elt.id)}/>)}</ul>
            <CustomerForm addCustomer={addCustomer} />
        </div>
    )
}
const Customer = ({param, handleDelete}) => (
    <li>{param.id}-{param.name}{' '} <button onClick={handleDelete}>X</button></li>
)

const CustomerForm = ({addCustomer}) =>{
    const [user, setUser] = useState('');
    const handleChange = e => setUser(e.currentTarget.value)
    const handleSubmit = e => {
        e.preventDefault()
        addCustomer(user)
        setUser('')
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" value={user} onChange={handleChange} placeholder="Add new customer"/>
            <button>Validate</button>
        </form>
    )
}

export default () => (
    <BrowserRouter>
        <div>
            <h1>Apps it's working</h1>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/about">About</Link></li>
                <li><Link to="/contact">Contact</Link></li>
            </ul>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/about" component={About}/>
                <Route exact path="/contact" component={Contact}/>
            </Switch>
        </div>
    </BrowserRouter>
)*/