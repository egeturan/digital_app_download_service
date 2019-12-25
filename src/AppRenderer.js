import React from 'react';
import ApplicationInformationPage from './ApplicationInformationPage';
import NavigationAda from './NavigationAda';
import HomePage from './Homepage';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import GLOBAL from './global';

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

        console.log("***********");
        alert("Logout Successful");
        GLOBAL.userG = null;
        GLOBAL.typeU = 0;
        this.props.history.push("/");

        this.setState({
            authenticate: 0
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
                    </div>
                );
            }else if(GLOBAL.typeU == 2){
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>Developer Page Will be</h1>
                    </div>
                );
            }else if(GLOBAL.typeU == 3){
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>Editor Page Will be</h1>
                    </div>
                );
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
                <ApplicationInformationPage></ApplicationInformationPage>
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