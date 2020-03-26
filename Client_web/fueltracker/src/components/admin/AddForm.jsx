import React, {useState} from "react";
import {Button, Col, FormGroup, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader, Row} from "reactstrap";
import {getUserById} from "../../utils/dev/Common";

export default function (props) {
    const [modal_add_form, setModalAddForm] = useState(false)

    //const userModified = getUserById(props.id)
    //if (props.modifre)

    const handleToggleModalAddForm = e => {
        e.stopPropagation()
        setModalAddForm(!modal_add_form);
    }

    const handleSubmit = e => {
        props.onSubmit(e)
        setModalAddForm(false)
    }



    return (
        <div className="text-right mb-3">
            <Button color="success" className="bg-teal" onClick={handleToggleModalAddForm}>Ajouter</Button>
            <Modal isOpen={modal_add_form} toggle={handleToggleModalAddForm} className={props.className}>
                <form onSubmit={handleSubmit}>
                    <ModalHeader toggle={handleToggleModalAddForm}>Ajout d'un client</ModalHeader>
                    <ModalBody>
                        <Row>
                            {props.widgets.map(elt => (
                                <Col xs="12">
                                    <FormGroup>
                                        <Label htmlFor={elt.id}>{elt.name}</Label>
                                        <Input {...elt.state} type={elt.type} id={elt.id} placeholder={elt.message ? elt.message : "Entrez votre " + elt.name} required={elt.required} />
                                    </FormGroup>
                                </Col>
                            ))}
                        </Row>
                    </ModalBody>
                    <ModalFooter>
                        <Button type="submit" color="primary" className="bg-teal">Enregistrer</Button>{' '}
                        <Button color="danger" onClick={handleToggleModalAddForm}>Fermer</Button>
                    </ModalFooter>
                </form>
            </Modal>
        </div>
    )
}