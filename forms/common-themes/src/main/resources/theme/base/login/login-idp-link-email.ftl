<#import "template.ftl" as layout>
<@layout.registrationLayout; section>
    <#if section = "title">
        ${msg("emailLinkIdpTitle", idpAlias)}
    <#elseif section = "header">
        ${msg("emailLinkIdpTitle", idpAlias)}
    <#elseif section = "form">
        <p class="instruction">
            ${msg("emailLinkIdp1", idpAlias, brokerContext.username, realm.name)}
        </p>
        <p class="instruction">
            ${msg("emailLinkIdp2")} <a href="${url.firstBrokerLoginUrl}">${msg("doClickHere")}</a> ${msg("emailLinkIdp3")}
        </p>
    </#if>
</@layout.registrationLayout>