#!groovy

import jenkins.model.*
import hudson.security.*
import hudson.plugins.active_directory.*
import javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration

def instance = Jenkins.getInstance()

def adrealm = new ActiveDirectorySecurityRealm('ni.corp.natinst.com', '', '', '', '', GroupLookupStrategy.RECURSIVE)
instance.setSecurityRealm(adrealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()

GlobalConfiguration.all().get(GlobalJobDslSecurityConfiguration.class).useScriptSecurity=false
