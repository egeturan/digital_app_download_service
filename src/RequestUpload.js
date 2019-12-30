import React from 'react';
import { Container, Divider, Form, Button, Icon } from 'semantic-ui-react';
import axios from 'axios';
import GLOBAL from './global';
import { Link, withRouter } from "react-router-dom";

class RequestUpload extends React.Component{
    state = {
        editorIds: [],
        showDisplay: 0,
        userId: 0,
        typeU: 0,
        app_name: "",
        price: "",
        explanation: "",
        ram: "",
        cpu: "",
        os_version: ""
    }

    componentDidMount(){

        axios.get(`http://localhost:8080/getEditors`)
        .then(response => {
          let newEditorIds = {editorIds: response.data};
          console.log(newEditorIds);
          this.setState(newEditorIds);

        });


    }

    isFormEmpty(){
        let result =  this.state.app_name.length &&
        this.state.price.length &&
        this.state.explanation.length && this.state.ram.length && this.state.cpu.length && this.state.os_version.length;
        console.log("Result is: " + result);
        return result;
      };

    handleSubmit = event => {
        event.preventDefault();

        if (this.isFormEmpty() != 0) {
            
        let uID = GLOBAL.userG;
        console.log("User is: ");
        console.log(GLOBAL.userG);
        let uType = GLOBAL.typeU;

        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = yyyy + '-' + mm + '-' + dd;

           //int editor_id, int developer_id, String app_name, String publishing_date, int price, String text, String logo)

          const user = {
            ram: this.state.ram,
            cpu: this.state.cpu,
            os_version: this.state.os_version,
            editor_id: this.state.showDisplay,
            developer_id: uID.user_id,
            app_name: this.state.app_name,
            publishing_date: today,
            price: this.state.price,
            text: this.state.explanation,
            logo: null
          };

          console.log(this.state.ram + " " + this.state.cpu + " " + this.state.os_version);


   axios.post(`http://localhost:8080/upload_request_app/`, user )
      .then(res => {
        console.log(res);
        alert("Request is sent successfully");
        
      })


      console.log(user);


        }
        
      };

      //Button Message pass
      chooseEditor(number) {
        console.log("editor_id is: " + number);
        this.setState({
            showDisplay: number
        });
      }

      handleChange = event => {
        this.setState({ [event.target.name]: event.target.value });
      };
  


    render(){

        const {
            app_name,
            price,
            explanation,
            ram,
            cpu,
            os_version
          } = this.state;

        let selected = null;

        if(this.state.showDisplay == 0){
            
        }else {
            selected = (
            <h1>Selected is: {this.state.showDisplay}</h1>
            );
        }


     
        return(

            <div>
            <h1>Available Editors are : </h1>
            
            <ul>
            { 
              this.state.editorIds.map(person => <li onClick={this.chooseEditor.bind(this, person.user_id)} style={{borderStyle: "solid ", width: "200px"}}>{person.user_id}</li>
            )}
            </ul>

            {selected}
            

            <div style={{width: "auto", height:"2500px", backgroundColor:"#f0f0f5"}}>
            
            <Container style={{width: "auto", height: "220px", backgroundColor: "white", marginTop: "40px"}}>
            <h1>App to Add</h1>
            <Divider/>
            <h4>Please hold and drag your app into box above </h4>
            <div style={{width: "auto", height: "100px", borderStyle: "solid", borderColor: "blue", backgroundColor:"#f0f0f5"}}>
            Add your app that you want to serve on ADA STORE<Icon name="download" size='huge' style={{marginTop: "20px"}}/>
            
            </div>
            </Container>

            <Container style={{width: "auto", height: "200px", backgroundColor: "white", marginTop: "30px"}}>
            <h1>Release Name</h1>
            <Divider/>
            <h4> Enter App Name, and Price  Below </h4>
            <Form onSubmit={this.handleSubmit} size="large">
                <Form.Group unstackable widths={1}>
                <Form.Input name="app_name" placeholder='app_name' onChange={this.handleChange} value={app_name} type="text"/>
                <Form.Input name="price" placeholder='price' onChange={this.handleChange} value={price} type="text"/>
                <Form.Input name="explanation" placeholder='explanation' onChange={this.handleChange} value={explanation} type="text"/>
                <Form.Input name="os_version" placeholder='os_version' onChange={this.handleChange} value={os_version} type="text"/>
                <Form.Input name="cpu" placeholder='cpu' onChange={this.handleChange} value={cpu} type="text"/>
                <Form.Input name="ram" placeholder='ram' onChange={this.handleChange} value={ram} type="text"/>
                </Form.Group>
                <Container style={{width: "auto", height: "100px", backgroundColor: "white", marginTop: "20px"}}>
            <Form.Checkbox label='I agree to the Terms and Conditions' style={{width: "auto", marginTop: "10px"}} />
            <Button color="blue">SUBMIT YOUR REQUEST</Button>
            <Button onClick={this.props.click}> Turn Back To Home page</Button>
            </Container>
            </Form>
            </Container>

         
    </div>
    </div>
        );
    };
}

export default withRouter(RequestUpload);
