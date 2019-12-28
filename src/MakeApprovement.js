import React from 'react';
import { Container, Divider, Button } from 'semantic-ui-react';
import axios from 'axios';
import GLOBAL from './global';
import Tab from 'react-bootstrap/Tab';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ListGroup from 'react-bootstrap/ListGroup';
import { withRouter } from "react-router-dom";

class MakeApprovement extends React.Component{
    state = {
        user: null,
        type: 0,
        requests: [],
        showDisplay: 0,
        userId: 0,
        typeU: 0,
        app_name: "",
        price: "",
        explanation: "",
        editor_id: ""
    }

    componentDidMount(){

        console.log(GLOBAL.userG);



        this.setState({
            user: GLOBAL.userG,
            type: GLOBAL.typeU,
            editor_id: GLOBAL.userG.user_id
        });



    axios.post(`http://localhost:8080/get_requested_apps`, GLOBAL.userG )
        .then(res => {
          console.log(res);

          let newRequests = {requests: res.data};
          console.log(newRequests);
          this.setState(newRequests);

          
 
        })




    }
    

    displayer(number) {
        
      }


    render(){

        return(
            <div style={{width: "auto", height:"2500px", backgroundColor:"#f0f0f5"}}>
            <Divider></Divider>
            <div textAlign="left" style={{overflowX : 'auto', fontSize: '20px', right: "0px", position: "fixed", alignSelf: "flex-end", width:"240px", height:"100px", top:"180px", borderStyle: "solid"}}>
              Editor Profile
              <br/> Editor ID : {this.state.editor_id}
              <Button onClick={this.props.click} style={{color: "yellow", backgroundColor: "blue"}}> Turn to Editor Menu</Button>
                </div>


            <Container textAlign="center">
            <h1>Recent Requests</h1>
            <Divider/>
            <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link0">
            <Row>
                <Col sm={4}>
                <ListGroup>
                { 
             
              this.state.requests.map((person, index) => <ListGroup.Item action href={"#link" + index}> {"Request " + (index + 1) }</ListGroup.Item>)}
  
                </ListGroup>
                </Col>
                <Col sm={8}>
                <Tab.Content>
                { 
             
             this.state.requests.map((person, index) =>   <Tab.Pane eventKey={"#link" + index}>
                <Container textAlign="left">
                <p style={{fontSize : "18px"}}> <strong> App name is: {person.app_name}
                    <br/>
                    App id is: {person.app_id}
                    <br/>
                    Price is: {person.price}
                    <br/>
                Expanation is: {person.text}
                <br/>
                Logo : null
                </strong>
                </p>
            <Button color="green">Approve Request</Button>
            <Button color="red">Reject Request</Button>
            </Container>
            </Tab.Pane>)}

                </Tab.Content>
                </Col>
            </Row>
            </Tab.Container>
            </Container>
        </div>
     
        );

    };

}

export default withRouter(MakeApprovement);
