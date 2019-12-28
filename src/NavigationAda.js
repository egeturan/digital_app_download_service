import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Button from 'react-bootstrap/Button';
import logo from './assets/images/ada-lovelace.jpg';


import {
  withRouter
} from "react-router-dom";

class NavigationAda extends React.Component {
  

  state = {
      authentication: 0
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

      let displayer = (
        <div>
        <Navbar bg="dark" variant="dark">
          <img src={logo} style={style1} className="App-logo" alt="logo"/>

        <Navbar.Brand href="#home" style={{marginLeft: "40px"}}> ADA STORE</Navbar.Brand>
        <Nav className="mr-auto">
          <Nav.Link href="#home" onClick={this.displaySwitch.bind(this, 5)}>Home</Nav.Link>
          <Nav.Link href="#features">Top Applications</Nav.Link>
       
        </Nav>

            <Button variant="success" onClick={this.displaySwitch.bind(this, 1)} style={{width: "150px", height: "50px"}}>Log In</Button>
            <Button variant="primary" onClick={this.displaySwitch.bind(this, 2)} style={{width: "150px", height: "50px"}}>Register as User</Button>
            <Button variant="success" onClick={this.displaySwitch.bind(this, 3)} style={{width: "150px", height: "50px"}}>Register as Editor</Button>
            <Button variant="primary" onClick={this.displaySwitch.bind(this, 4)} style={{width: "150px", height: "50px"}}>Register as Developer</Button>
            
      </Navbar>
      </div>
    );




    if(this.state.showDisplay == 1){
      this.props.history.push("/login");
    }else if(this.state.showDisplay == 2){
      this.props.history.push("/register");
    } else if(this.state.showDisplay == 3){
      this.props.history.push("/register-editor");
    } else if(this.state.showDisplay == 4){
      this.props.history.push("/register-developer");
    } else if(this.state.showDisplay == 5){
      this.props.history.push("/app-information");
    } 
      
      return (
        <div>
          {displayer}
          </div>

      );
    }
  }

  export default withRouter(NavigationAda);