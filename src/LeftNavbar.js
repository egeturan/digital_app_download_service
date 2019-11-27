import React from 'react';
import Nav from 'react-bootstrap/Nav';

export default class LeftNavbar extends React.Component{


    render(){
        return(
            <Nav defaultActiveKey="/home" className="flex-column">
            <Nav.Link href="/home" style={{backgroundColor: 'red'}}>ENTERTAINMENT</Nav.Link>
            <Nav.Link eventKey="link-1">APPS</Nav.Link>
            <Nav.Link eventKey="link-2">BOOKS</Nav.Link>
            <Nav.Link eventKey="link-2">MOVIES</Nav.Link>
            <Nav.Link eventKey="disabled" disabled>
                Personal Options
            </Nav.Link>
            <Nav.Link eventKey="link-2">Account</Nav.Link>
            <Nav.Link eventKey="link-2">Payment</Nav.Link>
            <Nav.Link eventKey="link-2">My Subscriptions</Nav.Link>
            <Nav.Link eventKey="link-2">Parent Guide</Nav.Link>
            </Nav>
        );
    }
}