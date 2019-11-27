import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import logo from './assets/images/ada-lovelace.jpg';
import profile from './assets/images/profile.png';
import Image from 'react-bootstrap/Image';

class NavigationAda extends React.Component {

    render() {

      
      const style1 = {
          width: '80px',
          height: '80px',
         
      };

      const style2 = {
        width: '80px',
        height: '80px',
        marginLeft: '30px'
    };
      
      return (
        <div>
      <Navbar bg="dark" variant="dark">
         <img src={logo} style={style1} className="App-logo" alt="logo"/>

      <Navbar.Brand href="#home" style={{marginLeft: "40px"}}> ADA STORE</Navbar.Brand>
      <Nav className="mr-auto">
        <Nav.Link href="#home">Home</Nav.Link>
        <Nav.Link href="#features">Top Applications</Nav.Link>
        <Button>Log In</Button>
        <Button>Register</Button>
      </Nav>

      <Form inline>
        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
        <Button variant="success">Search</Button>
      </Form>
      <Image src={profile} style={style2} alt='alt' roundedCircle />
    </Navbar>
    </div>
      );
    }
  }

  export default NavigationAda;