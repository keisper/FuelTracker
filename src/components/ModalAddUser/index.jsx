import React, {useState, useRef, useEffect} from "react";
import {Button, Modal, Form, Input, Select } from "antd";
import axios from "axios";

export default function ({opened, setOpened}) {

    const initialData = {
        nom: '',
        prenom: '',
        email: '',
        adresse: '',
        nationalite: '',
        pays: '',
        role: 'CUSTOMER',
        login: '',
        mdp: '',
    };

    const [loading, setLoading] = useState(false);
    const [data, setData] = useState(initialData);
    const form = useRef(null);


    const onFinish = values => {
        axios.post(`${process.env.REACT_APP_HOST_API_SERVICE}/creerUtilisateur`, values)
            .then(res => {
            console.log(res);
            console.log(res.data);
        });
    };

    const onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    const handleOk = e => {
        setLoading(true);
        setTimeout(() => {
            setLoading( false);
            form.current.submit();
            handleCancel(e)
        }, 3000);
    };

    const handleCancel = e => {
        e.preventDefault();
        form.current.resetFields();
        setOpened(false)
    };


    return (

        <Modal title="Ajouter un Utilisateur"
               visible={opened}
               onOk={handleOk}
               onCancel={handleCancel}
               footer={[
                   <Button key="back" type="danger" onClick={handleCancel}>Fermer</Button>,
                   <Button key="submit" type="primary" className="my-primary-color" loading={loading} onClick={handleOk}>Enregistrer</Button>,
              ]}
        >
            <Form ref={form} layout="vertical" initialValues={ data } onFinish={onFinish} onFinishFailed={onFinishFailed}>
                <Form.Item
                    label="Nom"
                    name="nom"
                    rules={[{ required: true, message: "Veuillez entrer un nom" }]}
                >
                    <Input autoComplete="off" />
                </Form.Item>
                <Form.Item label="Prénom" name="prenom"><Input autoComplete="off" /></Form.Item>
                <Form.Item label="Email" name="email"><Input type="email" autoComplete="off" /></Form.Item>
                <Form.Item label="Nationalié" name="nationalite"><Input autoComplete="off" /></Form.Item>
                <Form.Item label="Pays" name="pays"><Input autoComplete="off" /></Form.Item>
                <Form.Item label="Adresse" name="adresse"><Input autoComplete="off" /></Form.Item>
                <Form.Item
                    label="Rôle"
                    name="role"
                    rules={[{ required: true, message: "Veuillez entrer un nom d'utilisateur" }]}
                >
                    <Select >
                        <Select.Option value="CUSTOMER">Client</Select.Option>
                        <Select.Option value="ADMIN">Administrateur</Select.Option>
                    </Select>

                </Form.Item>
                <Form.Item
                    label="Nom d'utilisateur"
                    name="login"
                    rules={[{ required: true, message: "Veuillez entrer un nom d'utilisateur" }]}
                >
                    <Input autoComplete="off" />
                </Form.Item>
                <Form.Item
                    label="Mot de passe"
                    name="mdp"
                    rules={[{ required: true, message: "Veuillez entrer un mot de passe" }]}
                >
                    <Input.Password />
                </Form.Item>
            </Form>
        </Modal>
    );

}