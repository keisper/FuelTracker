import React, {Suspense, useEffect, useState} from 'react';
import {Link, Redirect, default as router, Switch, Route} from "react-router-dom";
import {users} from "../../utils/dev/Common";
import {
    Badge,
    Button, Col,
    Container, FormGroup, Input, Label,
    Modal, ModalBody, ModalFooter,
    ModalHeader,
    Pagination,
    PaginationItem,
    PaginationLink, Row,
    Table
} from "reactstrap";
import {
    AppAside,
    AppFooter,
    AppHeader,
    AppSidebar,
    AppSidebarFooter,
    AppSidebarForm,
    AppSidebarHeader,
    AppSidebarMinimizer,
    AppBreadcrumb2 as AppBreadcrumb,
    AppSidebarNav2 as AppSidebarNav,
} from '@coreui/react';
import Header from "./Header";
import Footer from "../Footer";

import routes from "../../routes"
import navigation from './_nav'
import AddForm from "./AddForm";
import {useFormInput} from "../../utils/tools";


export default function DashboardAdmin(props) {
    const [list_user, setListUser] = useState(users)
    //const [new_user, setNewUser] = useState({});

    let WIDGET_FORM_ADD = [
        {id: "last_name", name: "Nom", message: "", type: "text", required: true, state: useFormInput("")},
        {id: "first_name", name: "Prénom", message: "", type: "text", required: true, state: useFormInput("")},
        {id: "country", name: "Nationnalité", message: "", type: "text", required: true, state: useFormInput("")},
        {id: "address", name: "Adresse", message: "", type: "text", required: true, state: useFormInput("")},
        {id: "username", name: "Nom d'utilisateur", message: "", type: "text", required: true, state: useFormInput("")},
        {id: "password", name: "Mot de passe", message: "", type: "password", required: true, state: useFormInput("")},
        {id: "c_password", name: "Confirmer votre mot de passe", message: "Entrez à nouveau votre mot de passe.", type: "password", required: true, state: useFormInput("")},
    ]
    let num = 0;

    useEffect(() => {
        const {role} = JSON.parse(sessionStorage.user)
        if(role !== "ADMIN")
            return <Redirect to={{pathname: "/error/403", state: {prevUrl: props.location.pathname}}}/>
    })

    const loading = () => <div className="animated fadeIn pt-1 text-center">Loading...</div>

    const signOut = (e) => {
        e.preventDefault()
        props.history.push('/logout')
    }

    const handleDelete = id => {
        const keep = [...list_user]
        const index = keep.findIndex(i => i.id === id)
        keep.splice(index, 1)
        setListUser(keep)
    }

    const handleSubmit = e => {
        e.preventDefault()
        const keep = [...list_user]
        const keep2 = [...WIDGET_FORM_ADD]
        const new_user = {
            id: keep+1,
            nom: WIDGET_FORM_ADD[0].state.value,
            prenom: WIDGET_FORM_ADD[1].state.value,
            nationalite: WIDGET_FORM_ADD[2].state.value,
            adresse: WIDGET_FORM_ADD[3].state.value,
            username: WIDGET_FORM_ADD[4].state.value,
            password: WIDGET_FORM_ADD[5].state.value,
            token: `token ${keep+1}`,
            statut: true,
            role: "USER"
        }
        keep.push(new_user)
        setListUser(keep)
        WIDGET_FORM_ADD = keep2
    }

    return (
        <div className="app">
            <AppHeader fixed>
                <Suspense  fallback={loading()}>
                    <Header onLogout={e=>signOut(e)}/>
                </Suspense>
            </AppHeader>
            <div className="app-body">
                <AppSidebar fixed display="lg">
                    <AppSidebarHeader />
                    <AppSidebarForm />
                    <Suspense>
                        <AppSidebarNav navConfig={navigation} {...props} router={routes}/>
                    </Suspense>
                    <AppSidebarFooter />
                    <AppSidebarMinimizer />
                </AppSidebar>
                <main className="main">
                    <div className="container-fluid">
                        <div className="animated fadeIn">
                            <div className="card mt-4">
                                <div className="card-header bg-teal text-white">
                                    <strong>Clients</strong>
                                </div>
                                <div className="card-body">
                                    <AddForm widgets={WIDGET_FORM_ADD} onSubmit={handleSubmit} />

                                    <Table responsive bordered striped className="text-center">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Nom d'utilisateur</th>
                                            <th>Nationalité</th>
                                            <th>Adresse</th>
                                            <th>Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {list_user.map(user => {
                                            if (user.role !== 'ADMIN'){
                                                num++;
                                                return <tr>
                                                    <td className="text-center">{num}</td>
                                                    <td className="text-left">{user.nom}</td>
                                                    <td className="text-left">{user.prenom}</td>
                                                    <td>{user.username}</td>
                                                    <td>{user.nationalite}</td>
                                                    <td>{user.adresse}</td>
                                                    <td>
                                                        <Button color="primary" id={user.id} modified={true}>Infos</Button>
                                                        <Button color="danger" onClick={() => handleDelete(user.id)} to="#" className="ml-2">Delete</Button>
                                                    </td>
                                                </tr>
                                            }
                                        })}
                                        </tbody>
                                    </Table>
                                    <Pagination>
                                        <PaginationItem>
                                            <PaginationLink previous tag="button"/>
                                        </PaginationItem>
                                        <PaginationItem active>
                                            <PaginationLink tag="button">1</PaginationLink>
                                        </PaginationItem>
                                        <PaginationItem>
                                            <PaginationLink tag="button">2</PaginationLink>
                                        </PaginationItem>
                                        <PaginationItem>
                                            <PaginationLink tag="button">3</PaginationLink>
                                        </PaginationItem>
                                        <PaginationItem>
                                            <PaginationLink tag="button">4</PaginationLink>
                                        </PaginationItem>
                                        <PaginationItem>
                                            <PaginationLink next tag="button"/>
                                        </PaginationItem>
                                    </Pagination>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <AppFooter>
                <Suspense fallback={loading()}>
                    <Footer />
                </Suspense>
            </AppFooter>
        </div>
    );
}

