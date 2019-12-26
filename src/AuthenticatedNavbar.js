import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import logo from './assets/images/ada-lovelace.jpg';
import profile from './assets/images/profile.png';
import Image from 'react-bootstrap/Image';
import GLOBAL from './global';

import {
  withRouter
} from "react-router-dom";

class NavigationAda extends React.Component {



 

  
  

  state = {
      authentication: 1,
      showDisplay: 0,
      info: [
        {type: "Please Log in"},
        {type: "Welcome"},
        {type: "Logged in as: Developer"},
        {type: "Logged in as: Editor"},
      ]
  };

  
  
     //Button Message pass
     displaySwitch(number) {
      this.setState({
          showDisplay: number
      });
    }



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

      let displayer = null;




    let authenticatedNavbar = (
      <div>
      <Navbar bg="dark" variant="dark">
        <img src={logo} style={style1} className="App-logo" alt="logo"/>

      <Navbar.Brand href="#home" style={{marginLeft: "40px"}}> ADA STORE</Navbar.Brand>
      <Nav className="mr-auto">
        <Nav.Link href="#home">Home</Nav.Link>
        <Nav.Link href="#features">Top Applications</Nav.Link>
      </Nav>

      <Form inline>
        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
        <Button variant="success">Search</Button>
      </Form>
      <Button variant="light" onClick={this.props.click} style={{width: "150px", height: "50px"}}>Logout</Button>
      <Image src={profile} style={style2} alt='alt' roundedCircle onClick={this.displaySwitch.bind(this, 5)}/>
    <p style={{ color: 'white' }}>{this.state.info[GLOBAL.typeU].type}</p>
    </Navbar>
    </div>
  );


    if(this.state.authentication == 0){
       
    }else if(this.state.authentication == 1){
      displayer = authenticatedNavbar;
    }


    if(this.state.showDisplay == 9){
      
    }else if(this.state.showDisplay == 2){
      this.props.history.push("/register");
    } else if(this.state.showDisplay == 3){
      this.props.history.push("/register-editor");
    } else if(this.state.showDisplay == 4){
      this.props.history.push("/register-developer");
    } else if(this.state.showDisplay == 5){
      this.props.history.push("/profile-page");
    } 
      
      return (
        <div>
          {displayer}
          </div>

      );
    }
  }

  export default withRouter(NavigationAda);