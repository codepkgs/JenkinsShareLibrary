package org.devops

def SetImage(resource_type, resource_name, container_name, image_name, kubeconfig="~/.kube/config") {
    sh "kubectl --kubeconfig=’${kubeconfig}' set image --record ${resource_type}/${resource_name} ${container_name}=${image_name}"
}