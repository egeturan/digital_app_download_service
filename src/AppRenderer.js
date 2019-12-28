import React from 'react';
import ApplicationInformationPage from './ApplicationInformationPage';
import { Grid, Container, Divider, Statistic, Form, Button, Icon, Rating, GridColumn} from 'semantic-ui-react';
import NavigationAda from './NavigationAda';
import HomePage from './Homepage';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import GLOBAL from './global';
import UserHomepage from './UserHomepage';
import DimmerExampleDimmer from './DimmerExampleDimmer';
import RequestUpload from './RequestUpload';
import MakeApprovement from './MakeApprovement';

class AppRenderer extends React.Component{

    state= {
        showDisplay: 0,
        authenticate: 0,
        hashData: "",
        user: null,
        type: 0
    };

    changeScreen(displayOption) {
        this.setState({
            uzmanScreen: displayOption
        });
      }

      componentDidMount(){
        console.log("Type is: " + GLOBAL.typeU);

        if(GLOBAL.userG == null){
            console.log("It is null");
            this.setState({
                authenticate: 0
            });
        }else{
            console.log("User name is: " + GLOBAL.userG.username);
            console.log("It is not null");
            this.setState({
                authenticate: 1,
                user: GLOBAL.userG,
                type: GLOBAL.typeU
            });
        }
      }

      switchNameHandler = (newName) => {

        alert("Logout Successful");
        GLOBAL.userG = null;
        GLOBAL.typeU = 0;
        this.props.history.push("/");

        this.setState({
            authenticate: 0
        });
        
      }

      turnBackFromMakeAppoinment = (newName) => {  
        this.setState({
            showDisplay: 0
          });
      }

      displayer(number) {
        this.setState({
          showDisplay: number
        });
      }


    render(){

        let render = null;

        if(this.state.authenticate == 1){
            if(GLOBAL.typeU == 1){
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>User Page Will be</h1>
                    <UserHomepage></UserHomepage>
                    
                    </div>
                );
            }else if(GLOBAL.typeU == 2){
                if(this.state.showDisplay === 1){
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <RequestUpload></RequestUpload>
                        </div>
                    );
                }else{
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>Developer Page Will be</h1>
                    <Button  onClick={this.displayer.bind(this,
         1)} style={{color: "yellow", backgroundColor: "blue"}}> Make Request </Button>
                    <DimmerExampleDimmer></DimmerExampleDimmer>
                    </div>
                );
                    }
            }else if(GLOBAL.typeU == 3){
                if(this.state.showDisplay === 2){
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <MakeApprovement click={this.turnBackFromMakeAppoinment.bind(this, 'EGE')} ></MakeApprovement>
                        </div>
                    );
                }else{
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <h1>Editor Page Will be</h1>
                        <Button  onClick={this.displayer.bind(this,
         2)} style={{color: "yellow", backgroundColor: "blue"}}> Make Approvement </Button>
                        </div>
                    );
                        }
        
            }else{
                render = (
                    <div>
                    <h1>Unknown Page</h1>
                    </div>
                );
            } 
        }else{
            render = (
                <div>
                <NavigationAda></NavigationAda>
                <h1>Homepage for nonauthentication</h1>
                </div>
            );
        }


        return(
            <div>
                {render}


            </div>



        );


    };

}

export default AppRenderer;