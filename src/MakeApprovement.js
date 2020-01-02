import React from 'react';
import { Container, Divider, Button } from 'semantic-ui-react';
import axios from 'axios';
import GLOBAL from './global';
import Tab from 'react-bootstrap/Tab';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ListGroup from 'react-bootstrap/ListGroup';
import { withRouter } from "react-router-dom";
import ApproveRequest from "./axios/ApproveRequest";
import RejectRequest from "./axios/RejectRequest";

class MakeApprovement extends React.Component{
    state = {
        user: null,
        type: 0,
        requests: [],
        showDisplay: 0,
        userId: 0,
        typeU: 0,
        app_id: "",
        app_name: "",
        price: "",
        explanation: "",
        editor_id: "",
        situation: 0
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

    approve_delete(app_to_delete) {
        ApproveRequest({editor_id: this.state.editor_id, app_id: app_to_delete.app_id});
        this.setState(prevState => ({
            requests: prevState.requests.filter(app => app != app_to_delete)
            })
        );
    }

    reject_delete(app_to_delete) {
        RejectRequest({editor_id: this.state.editor_id, app_id: app_to_delete.app_id});
        this.setState(prevState => ({
                requests: prevState.requests.filter(app => app != app_to_delete)
            })
        );
    }

    displayer(number) {
        this.setState({
            showDisplay: number
        });
    }


    render() {

        return(
            <div style={{width: "auto", height:"auto", backgroundColor:"#f0f0f5"}}>
                <h2 textAlign="center"> Editor ID : {this.state.editor_id}</h2>
            <Divider></Divider>

            <Container textAlign="center">
            <h1>Recent Application Requests</h1>
            <Divider/>
            <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link0">
            <Row>
                <Col sm={4}>
                <ListGroup>
                { 
             
              this.state.requests.map((app, index) => <ListGroup.Item action href={"#request" + (index + 1)}> {" App Request " + (index + 1) }</ListGroup.Item>)}
  
                </ListGroup>
                </Col>
                <Col sm={8}>
                <Tab.Content>
                { 
             
             this.state.requests.map((app, index) =>   <Tab.Pane eventKey={"#request" + (index + 1)}>
                <Container textAlign="left">
                <p style={{fontSize : "18px"}}> <strong> App Name: {app.app_name}
                    <br/>
                    App ID: {app.app_id}
                    <br/>
                    App Price: {app.price}
                    <br/>
                    App Description: {app.text}
                    <br/>
                    App Logo: null
                </strong>
                </p>
                    <Button type="submit" color="green" onClick={this.approve_delete.bind(this, app)}>Approve Request</Button>
                    <Button type="submit" color="red" onClick={this.reject_delete.bind(this, app)}>Reject Request</Button>
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
